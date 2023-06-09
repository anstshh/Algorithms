package com.example.algorithms.customlist;

import java.util.Arrays;

public class CustomListImpl implements CustomList {

    private final String[] storage;
    private int size;

    public CustomListImpl() {
        storage = new String[10];
    }

    public CustomListImpl(int intSize) {
        storage = new String[intSize];
    }

    @Override
    public Integer add(Integer item) {
        return null;
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        return null;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage,index,storage,index+1,size-index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(String.valueOf(item));
        storage[index] = String.valueOf(item);
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        return null;
    }


    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if(index == -1) {
            throw new ElementNotFoundException();
        }
        if(index == size) {
            storage[size--] = null;
            return item;
        }
        System.arraycopy(storage,index+1,storage,index,size-index);
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        if(index==-1) {
            throw new ElementNotFoundException();
        }
        if(index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
            size--;
            return index;
    }

    @Override
    public boolean contains(Integer item) {
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        return 0;
    }

    @Override
    public int lastIndexOf(Integer item) {
        return 0;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        return Arrays.binarySearch(storage, item);
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(CustomList otherList) {
        return Arrays.equals(toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem (String item) {
        if (item == null)
            throw new NullItemException();
    }
    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException();
        }
    }
        private void validateIndex(int index) {
            if(index < 0 || index > size)
                throw new InvalidIndexException();
        }
}
