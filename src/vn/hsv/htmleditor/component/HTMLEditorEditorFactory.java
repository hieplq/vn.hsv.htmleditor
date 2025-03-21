package vn.hsv.htmleditor.component;

import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.factory.IEditorFactory;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MColumn;
import org.compiere.model.MMailText;
import org.compiere.util.Env;

import vn.hsv.htmleditor.webui.editor.HTMLEditor;

public class HTMLEditorEditorFactory implements IEditorFactory {

	public HTMLEditorEditorFactory() {
		// nothing to do
	}

	@Override
	public WEditor getEditor(GridTab gridTab, GridField gridField, boolean tableEditor) {
		
		MColumn column = MColumn.get(Env.getCtx(),gridField.getAD_Column_ID());
		boolean isHtml = column.get_ValueAsBoolean(MMailText.COLUMNNAME_IsHtml);
		if (isHtml){
			return new HTMLEditor(gridField, tableEditor);
		}
		return null;
	}

}
