package ru.madzi.o2;

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

public class O2DataObject extends MultiDataObject {

    public O2DataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/x-oberon-2", true);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    @MultiViewElement.Registration(displayName = "#LBL_O2_EDITOR",
    iconBase = "ru/madzi/o2/oberon2-icon.png",
    mimeType = "text/x-oberon-2",
    persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
    preferredID = "O2",
    position = 1000)
    @Messages("LBL_O2_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }
}
