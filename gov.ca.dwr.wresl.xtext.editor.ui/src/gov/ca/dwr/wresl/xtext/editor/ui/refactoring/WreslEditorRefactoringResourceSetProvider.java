package gov.ca.dwr.wresl.xtext.editor.ui.refactoring;

import static com.google.common.collect.Maps.newHashMap;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperJdtExtensions;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.ui.util.JdtClasspathUriResolver;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;
import com.google.inject.Provider;


public class WreslEditorRefactoringResourceSetProvider extends
		RefactoringResourceSetProvider {
	
	private final static Logger LOG = Logger.getLogger(XtextResourceSetProvider.class);
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	@Inject
	private IStorage2UriMapperJdtExtensions storage2UriMapper;
	
	public ResourceSet get(IProject project) {
		XtextResourceSet set = resourceSetProvider.get();
		set.getURIConverter().getURIMap().putAll(computePlatformURIMap(project));
		set.setClasspathURIContext(project);
		set.setClasspathUriResolver(new JdtClasspathUriResolver());
		configure(set);
		return set;
	}
	
	protected Map<URI, URI> computePlatformURIMap(IProject project) {
		HashMap<URI, URI> hashMap = newHashMap();
		if (!project.exists()) return hashMap;
		
		try {
			for (IProject iProject : project.getWorkspace().getRoot().getProjects()) {
				if (iProject.isAccessible()) {
					IPath location = iProject.getLocation();
					if (location != null)
						hashMap.put(URI.createPlatformResourceURI(iProject.getName(), true), URI.createFileURI(location.toFile().getPath()));
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return hashMap;
	}
}
