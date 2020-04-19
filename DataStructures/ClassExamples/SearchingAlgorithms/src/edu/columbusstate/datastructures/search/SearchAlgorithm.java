package edu.columbusstate.datastructures.search;

import java.util.Comparator;

public interface SearchAlgorithm<T>
{
    public boolean search(T[] array, T target, Comparator<T> comparator);
}
