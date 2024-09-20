package boards;

import java.util.ArrayList;
import java.util.List;

public class History {
    List<Representation> boards=new ArrayList<>();

    public void add(Representation representation) {
        boards.add(representation);
    }

    public Representation undo(){
        if(boards.isEmpty()){
            throw new IllegalStateException();
        }
        boards.remove(boards.size()-1);
        return boards.get(boards.size()-1);
    }

    public Representation getBoardAtMove(int moveIndex){
        while(boards.size()!=moveIndex){
            boards.remove(boards.size()-1);
        }
        return boards.get(moveIndex-1);
    }
}
