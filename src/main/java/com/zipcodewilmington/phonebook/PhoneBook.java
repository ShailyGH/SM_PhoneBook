package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ArrayList;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, ArrayList<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map)
    {
        this.phonebook = new HashMap<>();
    }

    public PhoneBook()
    {
        phonebook = new HashMap<>();
        //this(null);
    }

    public void add(String name, String phoneNumber) {
        if (hasEntry(name)){
            ArrayList<String> phNumbers =  phonebook.get(name);
            phNumbers.add(phoneNumber);
        }
        else {
            phonebook.put(name, new ArrayList<>(Collections.singleton(phoneNumber)));
            //phonebook.put(name, new ArrayList<String>());
        }
    }

    public void addAll(String name, String... phoneNumbers)
    {
        if (hasEntry(name))
        {
            ArrayList<String> phNumbers = phonebook.get(name);
            phNumbers.addAll(Arrays.asList(phoneNumbers));
        }
        else
        {
            //phonebook.put(name, Arrays.asList(phoneNumbers));
        }
    }

    public void remove(String name)
    {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if (phonebook.containsKey(name)) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public List<String> lookup(String name)
    {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)
    {
       for (Map.Entry<String, ArrayList<String>> phBookEntry : phonebook.entrySet()){
           if (phBookEntry.getValue().contains(phoneNumber)){
               return phBookEntry.getKey();
           }
       }
        return "No Entry Found";
    }

    public List<String> getAllContactNames()
    {
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> phBookEntry : phonebook.entrySet())
        {
            names.add(phBookEntry.getKey());
        }
        return names;
    }

    public Map<String, ArrayList<String>> getMap() {
        return phonebook;
    }
}
