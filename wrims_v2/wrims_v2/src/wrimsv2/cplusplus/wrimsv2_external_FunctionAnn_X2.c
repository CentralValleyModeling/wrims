#include <jni.h>
#include "wrimsv2_external_FunctionAnn_X2.h"

extern float ANN_X2(float* X2_prv0, float* X2_prv1, float* X2_prv2, float* X2_prv3,
	float* X2_prv4, float* DO_prv0, float* DO_prv1, float* DO_prv2, float* DO_prv3,
	float* DO_prv4, long* mon0, long* mon1, long* mon2, long* mon3, long* mon4,
	long* ave_type, long* currMonth, long* currYear, long* BeginDay, long* EndDay);


JNIEXPORT jfloat JNICALL Java_wrimsv2_external_FunctionAnn_1X2_Ann_1X2
	(JNIEnv *env, jobject obj, jfloat X2_prv0, jfloat X2_prv1, jfloat X2_prv2,
	jfloat X2_prv3, jfloat X2_prv4, jfloat DO_prv0, jfloat DO_prv1, jfloat DO_prv2,
	jfloat DO_prv3, jfloat DO_prv4, jint mon0, jint mon1, jint mon2, jint mon3, jint mon4,
	jint ave_type, jint currMonth, jint currYear, jint BeginDay, jint EndDay) {

	return ANN_X2(&X2_prv0, &X2_prv1, &X2_prv2, &X2_prv3, &X2_prv4,
		&DO_prv0, &DO_prv1, &DO_prv2, &DO_prv3, &DO_prv4,
		&mon0, &mon1, &mon2, &mon3, &mon4,
		&ave_type, &currMonth, &currYear, &BeginDay, &EndDay);
}
