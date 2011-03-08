#include <jni.h>
#include "wrimsv2_external_FunctionAnnEC.h"

extern float ANNEC(float* Qsac_prv0, float* Qsac_prv1, float* Qsac_prv2, float* Qsac_prv3,
	float* Qsac_prv4, float* Qexp_prv0, float* Qexp_prv1, float* Qexp_prv2, float* Qexp_prv3,
	float* Qexp_prv4, float* Qsjr_prv0, float* Qsjr_prv1, float* Qsjr_prv2, float* Qsjr_prv3,
	float* Qsjr_prv4, float* DXC_prv0, float* DXC_prv1, float* DXC_prv2, float* DXC_prv3,
	float* DXC_prv4, float* DICU_prv0, float* DICU_prv1, float* DICU_prv2, float* DICU_prv3,
	float* DICU_prv4, float* Qsac_oth_prv0, float* Qsac_oth_prv1, float* Qsac_oth_prv2,
	float* Qsac_oth_prv3, float* Qsac_oth_prv4, float* Qexp_oth_prv0, float* Qexp_oth_prv1,
	float* Qexp_oth_prv2, float* Qexp_oth_prv3, float* Qexp_oth_prv4,
	float* VernEC_prv0, float* VernEC_prv1, float* VernEC_prv2,float* VernEC_prv3,
	float* VernEC_prv4, long* mon0, long* mon1,
	long* mon2, long* mon3, long* mon4, long* location, long* ave_type, long* currMonth,
	long* currYear);


JNIEXPORT jfloat JNICALL Java_wrimsv2_external_FunctionAnnEC_AnnEC
	(JNIEnv *env, jobject obj, jfloat Qsac_prv0, jfloat Qsac_prv1, jfloat Qsac_prv2,
	jfloat Qsac_prv3, jfloat Qsac_prv4, jfloat Qexp_prv0, jfloat Qexp_prv1, jfloat Qexp_prv2,
	jfloat Qexp_prv3, jfloat Qexp_prv4, jfloat Qsjr_prv0, jfloat Qsjr_prv1, jfloat Qsjr_prv2,
	jfloat Qsjr_prv3, jfloat Qsjr_prv4, jfloat DXC_prv0, jfloat DXC_prv1, jfloat DXC_prv2,
	jfloat DXC_prv3, jfloat DXC_prv4, jfloat DICU_prv0, jfloat DICU_prv1, jfloat DICU_prv2,
	jfloat DICU_prv3, jfloat DICU_prv4, jfloat Qsac_oth_prv0, jfloat Qsac_oth_prv1,
	jfloat Qsac_oth_prv2, jfloat Qsac_oth_prv3, jfloat Qsac_oth_prv4, jfloat Qexp_oth_prv0,
	jfloat Qexp_oth_prv1, jfloat Qexp_oth_prv2, jfloat Qexp_oth_prv3, jfloat Qexp_oth_prv4,
	jfloat VernEC_prv0, jfloat VernEC_prv1, jfloat VernEC_prv2, jfloat VernEC_prv3, jfloat VernEC_prv4,
	jint mon0, jint mon1, jint mon2, jint mon3, jint mon4, jint location, jint ave_type,
	jint currMonth, jint currYear) {

	return ANNEC(&Qsac_prv0, &Qsac_prv1, &Qsac_prv2, &Qsac_prv3, &Qsac_prv4, &Qexp_prv0,
		&Qexp_prv1, &Qexp_prv2, &Qexp_prv3, &Qexp_prv4, &Qsjr_prv0, &Qsjr_prv1, &Qsjr_prv2,
		&Qsjr_prv3, &Qsjr_prv4, &DXC_prv0, &DXC_prv1, &DXC_prv2, &DXC_prv3, &DXC_prv4, &DICU_prv0,
		&DICU_prv1, &DICU_prv2, &DICU_prv3, &DICU_prv4, &Qsac_oth_prv0, &Qsac_oth_prv1,
		&Qsac_oth_prv2, &Qsac_oth_prv3, &Qsac_oth_prv4, &Qexp_oth_prv0, &Qexp_oth_prv1,
		&Qexp_oth_prv2, &Qexp_oth_prv3, &Qexp_oth_prv4,
		&VernEC_prv0, &VernEC_prv1, &VernEC_prv2, &VernEC_prv3, &VernEC_prv4,
		&mon0, &mon1, &mon2, &mon3, &mon4,
		&location, &ave_type, &currMonth, &currYear);
}
