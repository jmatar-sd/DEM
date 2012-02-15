/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.task;

import edu.coeia.cases.Case;
import edu.coeia.managers.ApplicationManager;
import edu.coeia.cases.CaseFacade;
import edu.coeia.main.CaseManagerFrame;

/**
 *
 * @author wajdyessam
 */
public class CaseRemoverTask implements Task{
    private final ProgressDialog dialog ;
    private final CaseManagerFrame frame;
    private final String caseName ;
    
    public CaseRemoverTask(final CaseManagerFrame frame, final String caseName) {
        this.dialog = new ProgressDialog(null, true, this);
        this.frame = frame;
        this.caseName = caseName;
    }
    
    @Override
    public void startTask() {
        this.dialog.startThread();
    }
    
    @Override
    public void doTask() throws Exception {
        removeCaseAction();
    }
    
    @Override
    public boolean isCancelledTask() {
        return this.dialog.isCancelledThread();
    }
  
    private void removeCaseAction() throws Exception{
        Case aCase = ApplicationManager.Manager.getCaseFromCaseName(caseName);
        CaseFacade caseFacade = CaseFacade.newInstance(aCase);
        // close the db
        caseFacade.closeCaseTags();
        boolean status = caseFacade.removeCase();
        this.frame.readCases(); // update view table
    }
}
