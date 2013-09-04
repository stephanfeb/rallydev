package com.rallydev.intellij.task.rally;

import com.intellij.openapi.project.Project;
import com.intellij.tasks.config.BaseRepositoryEditor;
import com.intellij.tasks.config.TaskRepositoryEditor;
import com.intellij.util.Consumer;
import com.rallydev.intellij.task.RallyRepository;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RallyRepositoryEditor extends BaseRepositoryEditor<RallyRepository> {

    protected JTabbedPane editorPanel;
    protected JComboBox workspaces;

    protected JComboBox projects;
    protected JCheckBox workspaceCheckBox;
    protected JCheckBox projectCheckBox;
    private JPanel filterPanel;

    public RallyRepositoryEditor(Project project, RallyRepository repository, Consumer<RallyRepository> changeListener) {
        super(project, repository, changeListener);
    }

    @Nullable
    @Override
    protected JComponent createCustomPanel() {
        return filterPanel;
    }

    @Override
    public void apply() {
        super.apply();
    }
}