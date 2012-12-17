package wrimsv2_plugin.debugger.view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

public class WPPFileIncExploreView extends ViewPart {
	private TreeViewer viewer;

	public class FileIncContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getChildren(Object parent) {
			File file = (File) parent;
			File[] files = file.listFiles();
			ArrayList<File> filesInc=new ArrayList<File> ();
			for (int i=0; i<files.length; i++){
				String path=files[i].getAbsolutePath();
				if (DebugCorePlugin.fileFolderWreslInc.contains(path.toLowerCase())){
					filesInc.add(files[i]);
				}
			}
			File[] fileArray = filesInc.toArray(new File[filesInc.size()]);
			return fileArray;
		}

		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		@Override
		public Object getParent(Object element) {
			File file = (File) element;
			return file.getParentFile();
		}

		@Override
		public boolean hasChildren(Object parent) {
			File file = (File) parent;
			return file.isDirectory();
		}

		@Override
		public void dispose() {

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}
		
	}
    
	public class FileLabelProvider extends LabelProvider {
		private final Image folderImage = DebugCorePlugin.getImageDescriptor("folder.gif").createImage();
		private final Image driveImage = DebugCorePlugin.getImageDescriptor("filenav_nav.gif").createImage();
		private final Image fileImage = DebugCorePlugin.getImageDescriptor("file_obj.gif").createImage();

		@Override
		public Image getImage(Object element) {
			File file = (File) element;
			if (file.isDirectory())
				return file.getParent() != null ? folderImage : driveImage;
				return fileImage;
			}

		@Override
		public String getText(Object element) {
			String fileName = ((File) element).getName();
			if (fileName.length() > 0) {
				return fileName;
			}
			return ((File) element).getPath();
		}
		
	}

	
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new FileIncContentProvider());
		viewer.setLabelProvider(new FileLabelProvider());
		viewer.setInput(File.listRoots());
		viewer.addOpenListener(new IOpenListener() {
			@Override
			public void open(OpenEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();

				File file = (File) selection.getFirstElement();
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.OPEN)) {
						try {
							desktop.open(file);
						} catch (IOException e) {
							WPPException.handleException(e);
						}
					}
				}
			}
		});
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}


