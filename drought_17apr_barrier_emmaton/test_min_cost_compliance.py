from min_cost_compliance2 import *


def min_cost_compliance():
    from scipy.optimize import fmin_cobyla


    no_of_weeks = 4    
    d0 = dtm.datetime(2014,4,27)
    d1 = d0 + dtm.timedelta(days=no_of_weeks*7)
    
    control_period = (d0,d1)
    control_step = days(7)
    x0 = np.ones(no_of_weeks)*3500.
    
    #qmin = [2925.] + 4*[4157]+4*[2800]+14*[2800.]
    qmin = [2925.] + 3*[4157.]
    assert len(x0) == len(qmin)
    #x0 = np.array([2925.000,4157.000,4159.286,5041.825,4157.000,4000.000,4047.321,4602.426,4000.000,3975.054,4245.750,4751.072,3603.672,3570.053,4386.907,4650.922,3344.813,3577.872,3764.932,3572.622,3322.971,3934.002,7410.723])
    x0 = np.array([2925.0, 4157.0, 4159.286, 5041.825])
    x0 = np.maximum(x0,qmin)+2000.
    control_description = ("timeseries/optimizer.dss",\
                           "/FILL+CHAN/RSAC155/FLOW//1DAY/OPTIMIZER/")
    salt_standards = standards()
    constraint_period = control_period #(dtm.datetime(2014,4,27),dtm.datetime(2014,11,1))
    
    min_flow = 1000.

    # Retrieve original Sac flow and NDO.
    base_file = "ndo_echo.dss"
    base_path_ndo = "/DSM2/NDO_BASE/FLOW//1DAY/%s/" % alt.upper()
    base_ndo = dss_retrieve_ts(base_file,base_path_ndo,unique = True)
    base_path_sac = "/DSM2/RSAC155/FLOW_BASE//1DAY/%s/" % alt
    sac = dss_retrieve_ts(base_file,base_path_sac,unique = True)
    ndo = base_ndo
    
    do_plot = False
    if do_plot:
        plt.plot(sac.times,sac.data,label="Sac")
        plt.plot(base_ndo.times,base_ndo.data,label="NDO")
        plt.legend()
        plt.show()
   
    base_flows = {"sac":sac,"ndo":ndo}
    
    # Give a reasonable lower and upper bound for ndo flow. 
    # The lower bound should be low enough to ensure it is non-compliant
    # Similarly, upper value must be surely compliant. 
    # Make the interval on the wide side -- the algorithm will 
    # chop it down VERY quickly.
    is_lower_bound = True
    constraint_step = control_step
    n = number_intervals(constraint_period[0],\
                         constraint_period[1],\
                         constraint_step)

    seq = [ticks_to_time(tck) for tck 
           in time_sequence(constraint_period[0],control_step,n+1)]
        
    water_cost = WaterCost(0.1)
    constraints= []
    for s in standards():
        active = s["active"]
        if not(active):
            print "Station inactive: %s" % s["name"]
        for i in range(len(seq)-1):
            period = (seq[i],seq[i+1])
            if type(active) == dtm.datetime:
                if period[1] <= active:
                    print "Discarded constraint"
                    print s["name"]
                    print seq[i]
                    continue                    
            c = ComplianceConstraint(s,period,is_lower_bound)    
            constraints.append(c)
    
    for i in range(len(x0)):
        constraints.append(ControlLowerBound(qmin[i],i))
    
    x = fmin_cobyla(water_cost, 
                    x0, 
                    constraints, 
                    args=(base_flows,min_flow,control_period,control_step), 
                    consargs=(base_flows,min_flow,control_description,control_period,control_step),
                    rhobeg=400.0, 
                    rhoend=1.0,
                    maxfun=1000, 
                    disp=2)

    
if __name__ == '__main__':
    #test_ndo_control_to_flow()
    logfilename = os.path.join(os.path.dirname("."),"cobyla_log.txt")
    logging.basicConfig(filename=logfilename,filemode='w',level=logging.DEBUG)
    logging.info("logging enabled")    
    min_cost_compliance()
    
    
    