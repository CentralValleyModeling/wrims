package wrimsv2.hdf5;

import java.io.File;

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
}
