package vn.hsv.htmleditor.webui.editor;

import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.event.ValueChangeEvent;
import org.compiere.model.GridField;
import org.zkforge.ckez.CKeditor;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Html;

public class HTMLEditor extends WEditor {
	private String oldValue;
	private static final String[] LISTENER_EVENTS = {Events.ON_CHANGE, Events.ON_CHANGING};
	
	public HTMLEditor(GridField gridField, boolean tableEditor)
    {
        super(new CKeditor(true, !gridField.isEditable(true)), gridField);
        CKeditor ckEditor = (CKeditor)getComponent();
        ckEditor.setRemoveButtons("About,Maximize,Image,Link,Blockquote,CreateDiv,Language,BidiRtl,BidiLtr,Unlink,Anchor,Flash,Table,HorizontalRule,Smiley,SpecialChar,PageBreak,Iframe,Save,NewPage,Preview,Print,Templates,Cut,Copy,Paste,PasteText,PasteFromWord,Redo,Undo,Find,Replace,SelectAll,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,RemoveFormat,CopyFormatting,JustifyLeft,JustifyCenter,JustifyRight,JustifyBlock,ShowBlocks");
        ckEditor.setToobarGroupConfig("[{\"name\": \"clipboard\",\"groups\": [ \"clipboard\", \"undo\" ] },		{\"name\": \"forms\",\"groups\": [ \"forms\" ] },		\"/\",		{\"name\": \"document\",\"groups\": [ \"mode\", \"document\", \"doctools\" ] },		{\"name\": \"links\",\"groups\": [ \"links\" ] },		{\"name\": \"insert\",\"groups\": [ \"insert\" ] },		{\"name\": \"basicstyles\",\"groups\": [ \"basicstyles\", \"cleanup\" ] },		{\"name\": \"paragraph\",\"groups\": [ \"list\", \"indent\", \"blocks\", \"align\", \"bidi\", \"paragraph\" ] },		\"/\",		{\"name\": \"editing\",\"groups\": [ \"find\", \"selection\", \"spellchecker\", \"editing\" ] },		{\"name\": \"styles\",\"groups\": [ \"styles\" ] },		{\"name\": \"colors\",\"groups\": [ \"colors\" ] },		{\"name\": \"tools\",\"groups\": [ \"tools\" ] },		{\"name\": \"others\",\"groups\": [ \"others\" ] },		{\"name\": \"about\",\"groups\": [ \"about\" ] }	]");
        this.tableEditor = tableEditor;
    }

	@Override
	public Component getDisplayComponent() {
		return new Html();
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getTarget() != this.getComponent()){
			return;//don't handle
		}
		
		if (Events.ON_CHANGING.equals(event.getName())){
			ValueChangeEvent changeEvent = new ValueChangeEvent(this, this.getColumnName(), oldValue, oldValue);
	        
	        changeEvent.setIsInitEdit(true);
	        
	        super.fireValueChange(changeEvent);
		}else if (Events.ON_CHANGE.equals(event.getName())){
			InputEvent editoEvent = (InputEvent)event;
			ValueChangeEvent changeEvent = new ValueChangeEvent(this, this.getColumnName(), oldValue, editoEvent.getValue());
			super.fireValueChange(changeEvent);
			oldValue = this.getComponent().getValue();
		}else{
			
		}
		
	}

	@Override
	public void setReadWrite(boolean readWrite) {
		getComponent().setReadonly(!readWrite);
	}

	@Override
	public boolean isReadWrite() {
		return getComponent().isReadonly();
	}

	@Override
	public void setValue(Object value) {
		if (value != null)
        {
            getComponent().setValue(value.toString());
        }
        else
        {
            getComponent().setValue("");
        }
		
        oldValue = getComponent().getValue();
	}

	@Override
	public Object getValue() {
		return getComponent().getValue();
	}

	@Override
	public String getDisplay() {
		return getComponent().getValue();
	}
	
	@Override
	public CKeditor getComponent() {
		return (CKeditor)super.getComponent();
	}
	
	@Override
    public String[] getEvents()
    {
        return LISTENER_EVENTS;
    }
}
