#include <jni.h>
//#include <windows.h>   // fixed undefined reference to 'LoadLibrary'
//#include <stdio.h>
#include "wrimsv2_external_FunctionAnnLineGen.h"

extern float ANNLINEGEN(float* Qsac_prv0, float* Qsac_prv1, float* Qsac_prv2,
  float* Qsac_prv3, float* Qexp_prv0, float* Qexp_prv1, float* Qexp_prv2, float* Qexp_prv3,
  float* Qsjr_prv0, float* Qsjr_prv1, float* Qsjr_prv2, float* Qsjr_prv3, float* Qsjr_fut,
  float* DXC_prv0, float* DXC_prv1, float* DXC_prv2, float* DXC_prv3, float* DXC_fut,
  float* DICU_prv0, float* DICU_prv1, float* DICU_prv2, float* DICU_prv3, float* DICU_fut,
  float* Qsac_oth_prv0, float* Qsac_oth_prv1, float* Qsac_oth_prv2, float* Qsac_oth_prv3,
  float* Qsac_oth_fut, float* Qexp_oth_prv0, float* Qexp_oth_prv1, float* Qexp_oth_prv2,
  float* Qexp_oth_prv3, float* Qexp_oth_fut,
  float* VernEC_prv0, float* VernEC_prv1, float* VernEC_prv2, float* VernEC_prv3, float* VernEC_fut,
  long* mon0, long* mon1, long* mon2, long* mon3,
  long* mon4, float* ECTARGET, float* linear1, float* linear2, long* location, long* variable,
  long* ave_type, long* currMonth, long* currYear, long* ForceOption);

/*
 * Class:     wrimsv2_external_FunctionAnnLineGen
 * Method:    AnnLineGen
 * Signature: (FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFIIIIIFFFIIIIII)F
 */
JNIEXPORT jfloat JNICALL Java_wrimsv2_external_FunctionAnnLineGen_AnnLineGen
 	(JNIEnv *env, jobject obj, jfloat Qsac_prv0, jfloat Qsac_prv1, jfloat Qsac_prv2,
  	jfloat Qsac_prv3, jfloat Qexp_prv0, jfloat Qexp_prv1, jfloat Qexp_prv2, jfloat Qexp_prv3,
	jfloat Qsjr_prv0, jfloat Qsjr_prv1, jfloat Qsjr_prv2, jfloat Qsjr_prv3, jfloat Qsjr_fut,
	jfloat DXC_prv0, jfloat DXC_prv1, jfloat DXC_prv2, jfloat DXC_prv3, jfloat DXC_fut,
	jfloat DICU_prv0, jfloat DICU_prv1, jfloat DICU_prv2, jfloat DICU_prv3, jfloat DICU_fut,
	jfloat Qsac_oth_prv0, jfloat Qsac_oth_prv1, jfloat Qsac_oth_prv2, jfloat Qsac_oth_prv3,
	jfloat Qsac_oth_fut, jfloat Qexp_oth_prv0, jfloat Qexp_oth_prv1, jfloat Qexp_oth_prv2,
	jfloat Qexp_oth_prv3, jfloat Qexp_oth_fut,
	jfloat VernEC_prv0, jfloat VernEC_prv1, jfloat VernEC_prv2, jfloat VernEC_prv3, jfloat VernEC_fut,
	jint mon0, jint mon1, jint mon2, jint mon3,
	jint mon4, jfloat ECTARGET, jfloat linear1, jfloat linear2, jint location, jint variable,
	jint ave_type, jint currMonth, jint currYear, jint ForceOption) {

  	return ANNLINEGEN(&Qsac_prv0, &Qsac_prv1, &Qsac_prv2, &Qsac_prv3, &Qexp_prv0, &Qexp_prv1,
  		&Qexp_prv2, &Qexp_prv3, &Qsjr_prv0, &Qsjr_prv1, &Qsjr_prv2, &Qsjr_prv3, &Qsjr_fut,
  		&DXC_prv0, &DXC_prv1, &DXC_prv2, &DXC_prv3, &DXC_fut, &DICU_prv0, &DICU_prv1, &DICU_prv2,
  		&DICU_prv3, &DICU_fut, &Qsac_oth_prv0, &Qsac_oth_prv1, &Qsac_oth_prv2, &Qsac_oth_prv3,
  		&Qsac_oth_fut, &Qexp_oth_prv0, &Qexp_oth_prv1, &Qexp_oth_prv2, &Qexp_oth_prv3,
  		&Qexp_oth_fut, &VernEC_prv0, &VernEC_prv1, &VernEC_prv2, &VernEC_prv3, &VernEC_fut,
  		&mon0, &mon1, &mon2, &mon3, &mon4, &ECTARGET, &linear1, &linear2, &location,
  		&variable, &ave_type, &currMonth, &currYear, &ForceOption);
}

