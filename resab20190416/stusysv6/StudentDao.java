package stusysv6;

import java.util.List;

public class StudentDao {
	
	public Integer exists(Integer id){
		Integer result=0,index=-1;
		for (Integer i=0;i<DataCenter.arrStu.size();i++){
			if (DataCenter.arrStu.get(i).getId()==id) {
				index = i;
				break;
			}
		}
		if (index>-1) {
			result = 1;
		}
		return result;
	}
	public List<Student> list() {
		return DataCenter.arrStu;
	}
//	public Integer getNewIndex(){
//		Integer index=0;
//		for (int i=0;i<DataCenter.arrStu.length;i++){
//			if (DataCenter.arrStu[i]== null) {
//				index = i;
//				break;
//			}
//		}
//		return index;
//	}
	public Integer insert(Student student) {
		Integer result=0;
		if(exists(student.getId())!=1) {
			DataCenter.arrStu.add(student);
			result = 1;
		}
		return result;
	}
//	public Integer searchId(Integer id) {
//		int index=-1;
//		for (int i=0;i<DataCenter.arrStu.length;i++){
//			if (DataCenter.arrStu[i]!= null && DataCenter.arrStu[i].getId().equals(id)) {
//				index = i;
//				break;
//			}
//		}
//		return index;
//	}
	public Integer update(Student student) {
		Integer result=0;
		for (int i = 0; i < DataCenter.arrStu.size(); i++) {
			if(DataCenter.arrStu.get(i) !=null) {
				if (DataCenter.arrStu.get(i).getId()==student.getId()) {
					DataCenter.arrStu.set(i, student);
					result=1;
					break;
				}
			}
		}
		return result;
	}
//	public boolean moveIndex(int index) {
//		boolean vIsOK=false;
//		if(index>=0 && index<=DataCenter.arrStu.length) {
//			int last=-1;
//			for(int i=index+1;i<DataCenter.arrStu.length;i++) {
//				if(DataCenter.arrStu[i]==null) {
//					last=i-1;
//					break;
//				}
//				DataCenter.arrStu[i-1]=DataCenter.arrStu[i];
//			}
//			if(last!=-1) {
//				DataCenter.arrStu[last]=null;
//				vIsOK=true;
//			}
//		}
//		return vIsOK;
//	}
	public Integer delete(Integer id) {
		Integer result=0;
		int index=-1;
		for (int i = 0; i < DataCenter.arrStu.size(); i++) {
			if (DataCenter.arrStu.get(i)!=null) {
				if (DataCenter.arrStu.get(i).getId()==id) {
					index = i;
					break;
				}
			}
		}
		if(index>-1) {
			DataCenter.arrStu.remove(DataCenter.arrStu.get(index));
			result = 1;
		}
		return result;
	}
}
