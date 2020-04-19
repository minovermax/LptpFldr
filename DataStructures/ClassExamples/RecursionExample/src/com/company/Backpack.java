package com.company;

public class Backpack<T extends String> implements Comparable<Backpack<T>>
{
    T content;
    public int capacity;
    String brand;

    public T returnContent(){
        return content;
    }

    public int returnCapacity()
    {
        return this.capacity;
    }

    @Override
    public String toString(){
        return brand + " " + capacity +" lbs";
    }

   @Override
   public boolean equals(Object obj){

        if(! (obj instanceof Backpack)) return false;

        return brand.equals(((Backpack) obj).brand); //under our criterion, two backpacks are equivalent if
       //they have the same brand.
   }

    @Override
    public int compareTo(Backpack<T> o) {

        return brand.compareTo(o.brand);
    }


}
