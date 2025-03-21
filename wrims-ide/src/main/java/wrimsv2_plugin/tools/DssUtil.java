/*
 * Water Resource Integrated Modeling System (WRIMS) Copyright (c) 2025.
 *
 * WRIMS 2 is copyrighted by the State of California Department of Water Resources.
 * It is licensed under the Eclipse Public License, Version 1.0.
 * See Eclipse Public License for more details.
 */

package wrimsv2_plugin.tools;

import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecDSSUtilities;
import hec.heclib.dss.HecDss;
import java.util.Vector;

public final class DssUtil {

    private DssUtil() {
        throw new AssertionError("Utility class");
    }

    /**
     * Optimization done to revert behavior of DSS catalog load to not query the period of record
     * extends for every record in the catalog. Instead, the nominal pathname will be the start -> end block
     * If DSS7 or small DSS 6 file, the nominal pathname will be the extents for the D-part.
     * If using a large DSS6 file, the start/end block will be used as the D-part in the nominal pathname.
     * @param hecDss dss file reference
     * @return condensed catalog
     */
    public static Vector<CondensedReference> getCondensedReferences(HecDss hecDss) {
        HecDSSUtilities dataManager = hecDss.getDataManager().getLocalDataManager();
        String[] sortedCatalog = dataManager.getCatalog(true, null);
        boolean queryTimes = dataManager.getDssFileVersion() == 7 || sortedCatalog.length < 5000;
        return dataManager.getCondensedCatalog(sortedCatalog, queryTimes);
    }
}
