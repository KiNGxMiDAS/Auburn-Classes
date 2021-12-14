/**
   * This method will test the deleteIceCreamCone() method.
   */
   
   @Test public void deleteIceCreamConeTest2() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);  
      iccList2.addIceCreamCone("Ex 2", 3, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
   
      iccList2.deleteIceCreamCone("ex 2");
   
      Assert.assertEquals("deleteIceCreamCone test", null, iccElements[3]);
      
      IceCreamConeList2 iccList3 = 
         new IceCreamConeList2("Label", null, 0);
      Assert.assertEquals("deleteIceCreamCone test", null, iccList3.deleteIceCreamCone("null"));
         
   }
   
   
   
   
   /**
   * This method will test the deleteIceCreamCone() method.
   */
   
   @Test public void deleteIceCreamConeTest3() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccListNull = 
         new IceCreamConeList2("Label", null, 0);
         
      Assert.assertEquals("deleteIceCreamCone test", null, iccListNull.deleteIceCreamCone("null"));
         
   }

