package com.laptrinhjavaweb.model;

public class Pet extends AbstractClass<Pet>{
    private String name;
    private Double price;
    private String type;
    private String breed;
    private int age;
    private String gender;
    private String description;
    private String addedBy;
    

    // Getters and Setters
    
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAddedBy() { return addedBy; }
    public void setAddedBy(String addedBy) { this.addedBy = addedBy; }

 
}
