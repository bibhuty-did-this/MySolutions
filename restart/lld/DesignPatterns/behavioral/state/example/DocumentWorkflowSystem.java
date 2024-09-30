package restart.lld.DesignPatterns.behavioral.state.example;

import java.util.Objects;

public class DocumentWorkflowSystem {
    public static void main(String[] args) {
        System.out.println("\nApprovedState test");
        validStateTest(true);
        System.out.println("\nRejectedState test");
        validStateTest(false);
        System.out.println("\nErrorState test");
        validStateTest(null);
    }

    private static void validStateTest(Boolean validState) {
        Document document = preDocumentApprovalStep();
        if (document.getState() instanceof ReviewState){
            ReviewState reviewState=(ReviewState) document.getState();
            reviewState.setApproved(validState);
        }
        postDocumentApprovalStep(document);
    }

    private static void postDocumentApprovalStep(Document document) {
        document.transitionToNextState();
        document.getState().execute();
    }

    private static Document preDocumentApprovalStep() {
        Document document=new Document();
        document.getState().execute();
        postDocumentApprovalStep(document);
        return document;
    }
}

class Document{
    State state;

    public Document() {
        this.state=new DraftState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void transitionToNextState(){
        State nextState = state.next();
        System.out.println("Transitioning from " + state.getClass().getSimpleName() + " to " + nextState.getClass().getSimpleName());
        this.state = nextState;
    }
}

interface State{
    State next();
    void execute();
}

class DraftState implements State{

    @Override
    public State next() {
        return new ReviewState();
    }

    @Override
    public void execute() {
        System.out.println("CurrentState: DraftState");
    }
}

class ReviewState implements State{

    Boolean isApproved;

    public ReviewState() {
        this.isApproved=null;
    }

    public ReviewState(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    @Override
    public State next() {
        if(Objects.isNull(isApproved)){
            throw new IllegalStateException("Can't get state of indeterministic approved state");
        }
        return isApproved ? new ApprovedState() : new RejectedState();
    }

    @Override
    public void execute() {
        System.out.println("CurrentState: ReviewState");
    }
}

class ApprovedState implements State{

    @Override
    public State next() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("CurrentState: ApprovedState");
    }
}

class RejectedState implements State{

    @Override
    public State next() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("CurrentState: RejectedState");
    }
}


