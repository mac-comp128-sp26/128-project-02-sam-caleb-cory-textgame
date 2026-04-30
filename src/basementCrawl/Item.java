package basementCrawl;

public class Item {

    private String name;

    public Item(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o){
        if (this.toString() == o.toString()){
            return true;
        }
        else return false;
    }
    
}
