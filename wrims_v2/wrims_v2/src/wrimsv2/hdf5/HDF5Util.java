package wrimsv2.hdf5;

import java.io.File;

import wrimsv2.components.ControlData;

import ncsa.hdf.hdf5lib.H5;
import ncsa.hdf.hdf5lib.HDF5Constants;
import ncsa.hdf.hdf5lib.exceptions.HDF5LibraryException;
import ncsa.hdf.object.HObject;
import ncsa.hdf.object.h5.H5File;

public class HDF5Util {
	
	public static int locateFile(String fileName){
		
		try {
			return H5.H5Fopen(fileName, HDF5Constants.H5F_ACC_RDWR, HDF5Constants.H5P_DEFAULT);
		} catch (Exception e) {
		
			try {
				return H5.H5Fcreate(fileName, HDF5Constants.H5F_ACC_TRUNC,
							HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
			} catch (HDF5LibraryException e1) {
				e1.printStackTrace();
				return -1;
			} catch (NullPointerException e1) {
				e1.printStackTrace();
				return -1;
			}
		}
	}
	
	public static int locateGroup(int id, String group){

		try {
			int gid = H5.H5Gopen(id, group, 0);
			if (gid<0){
				gid=H5.H5Gcreate(id, group,
				        HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
			}
			return gid;
		} catch (HDF5LibraryException e) {
			try {
				int gid = H5.H5Gcreate(id, group,
				        HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				return gid;
			} catch (HDF5LibraryException e1) {
				e1.printStackTrace();
				return -1;
			} catch (NullPointerException e1) {
				e1.printStackTrace();
				return -1;
			}
		} catch (NullPointerException e) {
			try {
				int gid = H5.H5Gcreate(id, group,
				        HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT, HDF5Constants.H5P_DEFAULT);
				return gid;
			} catch (HDF5LibraryException e1) {
				e1.printStackTrace();
				return -1;
			} catch (NullPointerException e1) {
				e1.printStackTrace();
				return -1;
			}
		}	
	}

	public static void writeStringData(int did, int tid, String[] stringArray, int stringLength){
		try {
			int size =stringArray.length;
			byte[][] write_data =  new byte[size][stringLength];
			for (int indx = 0; indx <size ; indx++) {
				for (int jndx = 0; jndx < stringLength; jndx++) {
					if (jndx < stringArray[indx].length())
						write_data[indx][jndx] = (byte) stringArray[indx].charAt(jndx);
					else
						write_data[indx][jndx] = 0;
				}
			}

			if ((did >= 0) && (tid >= 0))
				H5.H5Dwrite(did, tid, 
				        HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL, HDF5Constants.H5P_DEFAULT, 
				        write_data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeStringAttr(int aid, int tid, String[] stringArray, int stringLength){
		try {
			int size =stringArray.length;
			byte[][] write_data =  new byte[size][stringLength];
			for (int indx = 0; indx <size ; indx++) {
				for (int jndx = 0; jndx < stringLength; jndx++) {
					if (jndx < stringArray[indx].length())
						write_data[indx][jndx] = (byte) stringArray[indx].charAt(jndx);
					else
						write_data[indx][jndx] = 0;
				}
			}

			if ((aid >= 0) && (tid >= 0))
				H5.H5Awrite(aid, tid, write_data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeCycleStaticData(int index, int size, int gid, double[][] write_data){
		String dName="Cycle "+index+" Table";
		long[] dims = {1, size};
		long[] dims1 = {1, size};
		long[] maxDims={HDF5Constants.H5S_UNLIMITED, HDF5Constants.H5S_UNLIMITED};
		long[] chunkDims={1,5};
		
		int sidVs;
		try {				
			int didVs =-1;
			try{
				didVs = H5.H5Dopen(gid, dName);
				Integer currTimestep = ControlData.currTimeStep.get(index-1);
				dims[0]=currTimestep+1;
				H5.H5Dextend(didVs, dims);
				
				int fsidVs = H5.H5Dget_space (didVs);
				long[] offset1={0,0};
			    offset1[0] = currTimestep;
			    offset1[1] = 0;
			    H5.H5Sselect_hyperslab(fsidVs, HDF5Constants.H5S_SELECT_SET, offset1, null,
			                                  dims1, null); 
			    sidVs = H5.H5Screate_simple (2, dims1, null); 
			    
				H5.H5Dwrite(didVs, HDF5Constants.H5T_NATIVE_DOUBLE, 
					sidVs, fsidVs, HDF5Constants.H5P_DEFAULT, write_data);
				
				H5.H5Sclose(fsidVs);
				H5.H5Dclose(didVs);
				H5.H5Sclose(sidVs);
				
			}catch (Exception e){			
				sidVs = H5.H5Screate_simple(2, dims, maxDims);
				if (sidVs >= 0){
					int cparms = H5.H5Pcreate (HDF5Constants.H5P_DATASET_CREATE);
					H5.H5Pset_chunk ( cparms, 2, chunkDims);
					didVs = H5.H5Dcreate(gid, dName, HDF5Constants.H5T_NATIVE_DOUBLE, sidVs, cparms);
				
					if (didVs >= 0){		
						H5.H5Dextend(didVs, dims);
					
						int fsidVs = H5.H5Dget_space (didVs);
						long[] offset1={0,0};
						offset1[0] = 0;
						offset1[1] = 0;
						H5.H5Sselect_hyperslab(fsidVs, HDF5Constants.H5S_SELECT_SET, offset1, null,
								dims1, null); 
				    
						H5.H5Dwrite(didVs, HDF5Constants.H5T_NATIVE_DOUBLE, 
								sidVs, fsidVs, HDF5Constants.H5P_DEFAULT, write_data);
						
						H5.H5Sclose(fsidVs);
					}
				}
				H5.H5Dclose(didVs);
				H5.H5Sclose(sidVs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
