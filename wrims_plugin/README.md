# WRIMS Plugin build notes

### The plugin depends on 
1. the WRIMS Core project, which is built by the gradle sub-project wrims-core
2. hec.jar and vista.jar, which should be superceded by updated HEC dependencies to match WRIMS-core
3. Jars for jfreechart and jcommon. There are local copies of these at 
  - wrims_v2/wrims_plugin/lib_x64/jfreechart.jar
  - wrims_v2/wrims_plugin/lib_x64/sys/jcommon.jar<br>
but they don't match the jars in Maven Central or other repositories. Based on 
file dates in the jar and comparing decompiled sources from the local jars, this 
build was configured to use jfreechart v 1.0.17 and jcommon v 1.0.17. These jars 
are available on Maven central in the jfree.org organization. Earlier versions of 
the jars are available on Maven Central in the jfree (not jfree.org) organization.
<br>
In order to build the plugin with the Maven Central jars, it was necessary to refactor
an import in ReportPDFWriter.java from
  - `import org.jfree.chart.util.RectangleInsets;`
<br>to
  - `import org.jfree.ui.RectangleInsets;`
4. Classes in rma.jar
