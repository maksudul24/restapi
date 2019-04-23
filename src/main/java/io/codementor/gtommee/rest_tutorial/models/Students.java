package io.codementor.gtommee.rest_tutorial.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Students {
  @Id
  public ObjectId _id;
  
  public String Name;
  public String Roll;
  public String cgpa;
  public String Assignment;
  
  public Students() {}
  
  public Students(ObjectId _id, String Name, String Roll, String cgpa,String Assignment) {
    this._id = _id;
    this.Name = Name;
    this.Roll = Roll;
    this.cgpa = cgpa;
    this.Assignment= Assignment;
  }
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
 
  public String getName() { return Name; }
  public void setName(String Name) { this.Name = Name; }
 
  public String getRoll() { return Roll; }
  public void setRoll(String Roll) { this.Roll = Roll; }
 
  public String getCgpa() { return cgpa; }
  public void setCgpa(String cgpa) { this.cgpa =cgpa; }
  public String getAssign() {return Assignment;}
  public void setAssign(String Assignment) { this.Assignment= Assignment;}
}