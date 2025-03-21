-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
-- Mar 30, 2017 2:02:53 AM ICT
INSERT INTO AD_EntityType (EntityType,AD_Client_ID,AD_Org_ID,AD_EntityType_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,Name,Description,Processing,AD_EntityType_UU) VALUES ('vn.hsv.htmleditor',0,0,1000000,'Y',TO_TIMESTAMP('2017-03-30 02:02:53','YYYY-MM-DD HH24:MI:SS'),100,TO_TIMESTAMP('2017-03-30 02:02:53','YYYY-MM-DD HH24:MI:SS'),100,'vn.hsv.htmleditor','AD for IDEMPIERE-2310','N','31674600-94e0-4a4a-a060-54a2af2565ec')
;
commit;
-- Mar 30, 2017 2:02:53 AM ICT
INSERT INTO AD_Column (AD_Column_ID,Version,Name,Description,AD_Table_ID,ColumnName,DefaultValue,FieldLength,IsKey,IsParent,IsMandatory,IsTranslated,IsIdentifier,SeqNo,IsEncrypted,AD_Reference_ID,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,AD_Element_ID,IsUpdateable,IsSelectionColumn,EntityType,IsSyncDatabase,IsAlwaysUpdateable,IsAutocomplete,IsAllowLogging,AD_Column_UU,IsAllowCopy,SeqNoSelection,IsToolbarButton,IsSecure,FKConstraintType) VALUES (1000000,0,'HTML','Text has HTML tags',101,'IsHtml','N',1,'N','N','N','N','N',0,'N',20,0,0,'Y',TO_TIMESTAMP('2017-03-30 02:02:53','YYYY-MM-DD HH24:MI:SS'),100,TO_TIMESTAMP('2017-03-30 02:02:53','YYYY-MM-DD HH24:MI:SS'),100,1510,'Y','N','vn.hsv.htmleditor','Y','N','N','Y','351dd31d-d9ba-45bf-b53e-63931a60b4b1','Y',0,'N','N','N')
;
commit;
-- Mar 30, 2017 2:03:03 AM ICT
ALTER TABLE AD_Column ADD COLUMN IsHtml CHAR(1) DEFAULT 'N' CHECK (IsHtml IN ('Y','N'))
;
commit;

-- Mar 30, 2017 3:17:09 AM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1000000,'HTML','Text has HTML tags',101,1000000,'Y',0,480,0,'N','N','N','N',0,0,'Y',TO_TIMESTAMP('2017-03-30 03:17:09','YYYY-MM-DD HH24:MI:SS'),100,TO_TIMESTAMP('2017-03-30 03:17:09','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','vn.hsv.htmleditor','2d929e3b-4bad-4001-8af2-b1b6572f190b','Y',450,1,1,1,'N','N','N')
;

-- Mar 30, 2017 3:18:45 AM ICT
UPDATE AD_Field SET DisplayLogic='@AD_Reference_ID@=34|@AD_Reference_ID@=10|@AD_Reference_ID@=14|@AD_Reference_ID@=36', AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, IsToolbarButton=NULL,Updated=TO_TIMESTAMP('2017-03-30 03:18:45','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000000
;

-- Mar 30, 2017 3:19:21 AM ICT
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=135, AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, XPosition=5, IsToolbarButton=NULL,Updated=TO_TIMESTAMP('2017-03-30 03:19:21','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000000
;

commit;
