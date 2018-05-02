/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dashboard.view;

import com.iso.dashboard.component.CustomGridEditRow;
import com.iso.dashboard.controller.TaskPiorityController;
import com.iso.dashboard.utils.BundleUtils;
import com.iso.dashboard.utils.Constants;
import com.iso.dashboard.utils.ISOIcons;
//import com.jensjansson.pagedtable.PagedTable;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author VIET_BROTHER
 */
public class CataTaskPriorityMngtView extends Panel implements View {

    private TextField txtTaskGroupName;
    private ComboBox cmbStatus;

    private Button btnAdd;
    private Button btnRefresh;

    private CustomGridEditRow pagedTable;


    public CataTaskPriorityMngtView() {
        setSizeFull();
        addStyleName(ValoTheme.PANEL_BORDERLESS);
        setSizeFull();
        VerticalLayout root = new VerticalLayout();
        root.setCaption(BundleUtils.getStringCas("menu.taskPriorityMngt"));
        root.setSizeFull();
        root.setSpacing(false);
        root.addStyleName("dashboard-view");
        Responsive.makeResponsive(root);

        Component content = buildContent();
        TabSheet tabSheet = new TabSheet();
        tabSheet.setStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        tabSheet.setStyleName(ValoTheme.TABSHEET_ICONS_ON_TOP);
        setContent(tabSheet);
        tabSheet.addComponent(root);
        root.addComponent(content);
        root.setExpandRatio(content, 1);
        
        new TaskPiorityController(this);
    }

    private Component buildContent() {
        CssLayout contenPanel = new CssLayout();
        contenPanel.addStyleName("dashboard-panels");
        Responsive.makeResponsive(contenPanel);

        contenPanel.addComponent(buildToolbar());
        contenPanel.addComponent(buildResultLayout());

        return contenPanel;
    }

    private Component buildToolbar() {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);
        Responsive.makeResponsive(header);

        HorizontalLayout tools = buildButtonForm();
        tools.addStyleName("toolbar");
        header.addComponent(tools);
        header.setExpandRatio(tools, 3.0f);

        return header;
    }

    private Component buildResultLayout() {
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");

        VerticalLayout tableLayout = new VerticalLayout();
        tableLayout.setSizeFull();
        CustomGridEditRow table = createTable();
        tableLayout.addComponent(table);
        mainLayout.addComponent(tableLayout);
        mainLayout.setComponentAlignment(tableLayout, Alignment.MIDDLE_LEFT);

        mainLayout.setMargin(true);
        return mainLayout;
    }

    public CustomGridEditRow createTable() {
        pagedTable = new CustomGridEditRow();
        
        return pagedTable;
    }

    private HorizontalLayout buildButtonForm() {
        HorizontalLayout buttonForm = new HorizontalLayout();
        buttonForm.setHeight(Constants.STYLE_CONF.AUTO_VALUE);
        Responsive.makeResponsive(buttonForm);
        buttonForm.setSpacing(true);

        btnAdd = new Button();
        btnAdd.setCaption(BundleUtils.getString("common.button.add"));
        btnAdd.setDescription(BundleUtils.getString("common.button.add"));
        btnAdd.setIcon(ISOIcons.ADD);
        btnAdd.setImmediate(true);
        btnAdd.setWidth(Constants.STYLE_CONF.AUTO_VALUE);
        btnAdd.setHeight(Constants.STYLE_CONF.AUTO_VALUE);
        buttonForm.addComponent(btnAdd);

        btnRefresh = new Button();
        btnRefresh.setCaption(BundleUtils.getString("common.button.refresh"));
        btnRefresh.setDescription(BundleUtils.getString("common.button.add"));
        btnRefresh.setIcon(ISOIcons.REFRESH);
        btnRefresh.setImmediate(true);
        btnRefresh.setWidth(Constants.STYLE_CONF.AUTO_VALUE);
        btnRefresh.setHeight(Constants.STYLE_CONF.AUTO_VALUE);
        buttonForm.addComponent(btnRefresh);

        return buttonForm;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //action when load view
    }

    public ComboBox getCmbStatus() {
        return cmbStatus;
    }

    public void setCmbStatus(ComboBox cmbStatus) {
        this.cmbStatus = cmbStatus;
    }

    public TextField getTxtStaffCode() {
        return txtTaskGroupName;
    }

    public void setTxtStaffCode(TextField txtStaffCode) {
        this.txtTaskGroupName = txtStaffCode;
    }


    public Button getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    public CustomGridEditRow getPagedTable() {
        return pagedTable;
    }

    public void setPagedTable(CustomGridEditRow pagedTable) {
        this.pagedTable = pagedTable;
    }

    public Button getBtnRefresh() {
        return btnRefresh;
    }

    public void setBtnRefresh(Button btnRefresh) {
        this.btnRefresh = btnRefresh;
    }

    
}
