package hu.silur.QuestEditor.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Quest {

    public int id;
    public String Title;
    public String Description;
    public String OngoingText;
    public String OnfinishedText;
    public List<Integer> QuestGivers;
    public List<Requirement> requirements;
    public List<Integer> Prerequisites;

    public Quest(int id) {
        this.id = id;
        Title = "New Quest";
        Description = "Write your quest details here";
        OnfinishedText = "Yaay, you finished the quest!";
        OngoingText = "Hey, this is easy! Don't mess around!";
        QuestGivers = new ArrayList<>();
        QuestGivers.add(0);
        Prerequisites = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add(new Requirement(0,ReqType.KILL,10));

    }
    public static class Requirement {
        private final IntegerProperty id;
        public final StringProperty type;
        public final IntegerProperty count;
        private ReqType rType;

        public int getId() {
            return id.get();
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public String getType() {
            return type.get();
        }

        public void setType(String type) {
            this.type.set(type);
        }

        public int getCount() {
            return count.get();
        }


        public void setCount(int count) {
            this.count.set(count);
        }

        public ReqType getrType(){
            return rType;
        }

        public Requirement(Integer _id, ReqType rType, Integer _count) {
            this.id = new SimpleIntegerProperty(_id);
            this.rType = rType;
            this.type = new SimpleStringProperty(rType.getName());
            this.count = new SimpleIntegerProperty(_count);
        }


    }
}
