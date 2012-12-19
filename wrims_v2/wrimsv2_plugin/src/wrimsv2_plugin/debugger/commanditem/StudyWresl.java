package wrimsv2_plugin.debugger.commanditem;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;

import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;
import wrimsv2_plugin.debugger.view.WPPFileIncExploreView;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;
import wrimsv2_plugin.tools.FileProcess;

public class StudyWresl extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WPPDebugTarget target = DebugCorePlugin.target;
		if (target ==null || target.isTerminated()){
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
		        IStructuredSelection ssel = (IStructuredSelection) selection;
		        Object firstEle = ssel.getFirstElement();
		        IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(firstEle,
		                IFile.class);
		        if (ifile != null) {
		        	String path = ifile.getRawLocation().toOSString();
		        	
		        	try {
						StudyDataSet sds = StudyUtils.checkStudy(path);
						UpdateWreslIncExplore();
						
						/*
						String[] fns=data.split("*");
						DebugCorePlugin.fileFolderWreslInc=FileProcess.retrieveFileNames(fns);
						UpdateWreslIncExplore();
						*/
						
					} catch (IOException e) {
						WPPException.handleException(e);
					}
		        }
		    }
		}else {
			
		}
		return null;
	}
	
	public void UpdateWreslIncExplore(){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
				WPPFileIncExploreView wreslIncExplore;
				try {
					wreslIncExplore = (WPPFileIncExploreView) workBenchPage.showView(DebugCorePlugin.ID_WPP_FILEINCEXPLORE_VIEW);
					//wreslIncExplore.update();
				} catch (PartInitException e) {
					WPPException.handleException(e);
				}
			}
		});
	}
}
