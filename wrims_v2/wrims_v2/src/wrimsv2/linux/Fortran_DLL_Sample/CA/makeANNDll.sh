ifort -fpic -c SFtide.f90
ifort -fpic -c fnet_antioch.f90 
ifort -fpic -c fnet_CCFB.f90 
ifort -fpic -c fnet_CCFB_intake.f90 
ifort -fpic -c fnet_CO.f90 
ifort -fpic -c fnet_CVP_intake.f90 
ifort -fpic -c fnet_emm.f90 
ifort -fpic -c fnet_jp.f90 
ifort -fpic -c fnet_LosVaqueros.f90 
ifort -fpic -c fnet_Mallard.f90 
ifort -fpic -c fnet_MidR_intake.f90 
ifort -fpic -c fnet_orrsl.f90 
ifort -fpic -c fnet_Victoria_intake.f90 
ifort -fpic -c fnet_X2.f90 
ifort -fpic -c ConservativeSpline.f90
ifort -fpic -c DATIME.FOR 
ifort -fpic -c ICENTURY.FOR 
ifort -fpic -c IYMDJL.FOR 
ifort -fpic -c ut.f90
ifort -fpic -c ann.f90
ifort -fpic -c ann_ext.f90
ifort -fpic -c annec.f90
ifort -fpic -c AnnLineGen.f90
ifort -fpic -c ann_x2_ext.f90 
ifort -fpic -c annx2.f90 
ifort -fpic -c X2.f90

ifort -shared -o libann7inp_ca.so SFtide.o ann.o ann_ext.o ann_x2_ext.o annec.o AnnLineGen.o annx2.o ConservativeSpline.o DATIME.o fnet_antioch.o fnet_CCFB.o fnet_CCFB_intake.o fnet_CO.o fnet_CVP_intake.o fnet_emm.o fnet_jp.o fnet_LosVaqueros.o fnet_Mallard.o fnet_MidR_intake.o fnet_orrsl.o fnet_Victoria_intake.o fnet_X2.o ICENTURY.o IYMDJL.o ut.o X2.o

