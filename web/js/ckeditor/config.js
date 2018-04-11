/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	config.toolbarGroups = [
	                		
	                		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
	                		{ name: 'insert', groups: [ 'insert' ] },		
	                		{ name: 'others', groups: [ 'others' ] },	
	                		{ name: 'links', groups: [ 'links' ] },	
	                		{ name: 'tools', groups: [ 'tools' ] },	
	                		{ name: 'document', groups: [  'mode' ] },
	                		'/',
	                		{ name: 'styles', groups: [ 'styles' ] },
	                		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },		
	                		{ name: 'colors', groups: [ 'colors' ] }
	                	];
	config.removeButtons = 'Save,NewPage,Preview,Print,Templates,Form,Checkbox,TextField,Radio,Textarea,Select,Button,ImageButton,HiddenField,SelectAll,Scayt,Replace,Flash,Smiley,PageBreak,Iframe,CreateDiv,Language,BidiRtl,BidiLtr,Font,Styles,FontSize';
	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';
	config.fillEmptyBlocks =true;
	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';

	config.allowedContent = 'p h1 h2 h3 h4 h5 h6 span em li ul dd dt dl article b strong blockquote ol [class,style]{*}(*);img[src,alt,width,height,class,style]{*}(*);a[href,title,target,class,style]{*}(*);div[class,style]{*}(*);table tr td th tbody thead[*]{*}(*) ';
	
	config.extraPlugins = 'image2';
	//'h1[class](*);h2[class](*);h3[class](*);h4[class](*);h5[class](*);h6[class](*);p[class](*);div[class](*);span[class](*);em[class](*);img[src,alt,width,height,class](*);a[href,title,target,class](*);li[class](*);ul[class](*);dd[class](*);dt[class](*),table[class](*)'; 	
};
