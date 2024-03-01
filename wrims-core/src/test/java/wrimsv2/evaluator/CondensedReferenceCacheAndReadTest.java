/*
 * Copyright (c) 2024
 * United States Army Corps of Engineers - Hydrologic Engineering Center (USACE/HEC)
 * All Rights Reserved.  USACE PROPRIETARY/CONFIDENTIAL.
 * Source may not be released without written approval from HEC
 */

package wrimsv2.evaluator;

import hec.io.TimeSeriesContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CondensedReferenceCacheAndReadTest {

    @Test
    public void test_readdss() {
        String dvPath = "src/test/resources/dss/CS3L2020SV_SJWadj_LYRA.dss";
        String path = "/CALSIM/YUBAUNIMPAIRED/FLOW//1MON/L2020A/";
        CondensedReferenceCacheAndRead.CondensedReferenceCache cacheSvar = CondensedReferenceCacheAndRead.createCondensedCache(dvPath);
        TimeSeriesContainer tsc = cacheSvar.readFullRecord(path);
        assertEquals(1200, tsc.getValues().length);
    }

}