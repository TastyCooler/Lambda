class Main {
   public static void main( String[] args )
    {
        IntIntPairs testPairs = new IntIntPairs( 20 );
        testPairs.put(7,3); testPairs.put(4,3); testPairs.put(1,-9); testPairs.put(6,6); testPairs.put(2,8); 
        testPairs.put(41,12); testPairs.put(9,-11); testPairs.put(8,12); testPairs.put(5,-60); testPairs.put(14,18); 
        testPairs.put(0,12); testPairs.put(-9,-16); testPairs.put(0,0); testPairs.put(17,32); testPairs.put(0,1);
              testPairs.show();
        
        /*System.out.println("Beispiel: " + testPairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } ) );

        System.out.print("Beispiel: " + sumUp( testPairs ) ); System.out.println(); */
  
 

       /* Bestimmen Sie die Anzahl der gültigen geraden Werte in keys. */
        /*System.out.println("Anzahl der gültigen geraden Werte in keys " + testPairs.accumulate( (k, v) -> { if (k % 2 == 0){ return 1;} else {return 0;}})); */

      /*  Löschen Sie alle gültigen Paare, deren Wert in keys gleich dem Wert 6 ist */
      /*testPairs.remove((k,v) -> {if (k == 6){return true;} else{return false;}});*/
      

      /* Erhöhen Sie jeden gültigen Wert in keys um den Wert 10. */
     /* testPairs.manipulate(
        (k,v) -> { return k + 10;}, (k,v) -> {return v;} ); */
        

      /*  Erstellen Sie ein IntIntPairs-Objekt, das Kopien aller gültigen Paare enthält, deren Wert in values ganzzahlig durch 3 teilbar ist. */
     /* IntIntPairs newPairs = testPairs.extract(
        (k,v) -> { if(v % 3 == 0){return true;} else{return false;}}
      );
      newPairs.show(); */

      /* Bestimmen Sie die Anzahl der gültigen Werte in values, die größer als 10 sind */
      /*System.out.println("Anzahl der gültigen Werte in values " + testPairs.accumulate(
        (k,v) -> { if( v > 10) return 1; else{ return 0;}}
      )); */

      /*  Erhöhen Sie die Werte von in keys um den Wert 5, deren zugehöriger Wert in values größer als 3 ist. */
     /* testPairs.manipulate(
        (k,v) -> {if(v > 3){return k + 5;} else{return k;}} , (k,v) ->{ return v;}
      );
      testPairs.show(); */
    

    /*  Löschen Sie alle gültigen Paare, die einen negativen Wert in values besitzen */
   /* testPairs.remove(
      (k,v) -> {if(v < 0){ return true;} else {return false;}}
    ); */

    /* Verdoppeln Sie jeden gültigen Wert in values. */
    /* testPairs.manipulate((k,v) -> {return k;}, (k,v) -> {return v * 2;}); */

  /* Erstellen Sie eine Kopie des IntIntPairs-Objekts, das alle gültigen Paare enthält. */
 /* IntIntPairs newPairs = testPairs.extract((k,v)-> {return true;}); */

  /*  Löschen Sie alle gültigen Paare, deren beide Werte identisch sind. */
  testPairs.remove((k,v) -> {if(k == v){ return true;} else{return false;}});

/*  Bilden Sie die Summe aller gültigen Werte in values. */
testPairs.accumulate((k,v) -> { return v;});

/* Erstellen Sie ein IntIntPairs-Objekt, das Kopien aller gültigen Paare enthält, deren Wert in values größer als der Wert 5 ist. */

IntIntPairs newPairs = testPairs.extract((k,v) -> {if(v > 5){return true;}else{return false;}});

    }


/* Implementieren Sie eine Methode sumUp(IntIntPairs pairs), die für die gültigen Paare in pairs, deren Wert in
keys gleich 0 ist, die zugehörigen Werte aus values aufsummiert. */
    public static int sumUp(IntIntPairs pairs)
    {
        return pairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } );
    }
    
    /* Implementieren Sie eine Methode addNToValue(IntIntPairs pairs, int n), die für die gültigen Paare in pairs die Werte in values um den Wert n erhöht. */
     public static void addNToValue( IntIntPairs pairs, int n )
    {
              pairs.manipulate((k,v) -> k, (k,v) -> v+n);
    }
     
     /* Implementieren Sie eine Methode uniqueKey(IntIntPairs pairs, int n), die true zurückgibt, wenn in allen gültigen Paaren in pairs der Wert von n in keys genau einmal auftritt. */
     public static boolean uniqueKey( IntIntPairs pairs, int n )
     {
         return pairs.accumulate((k,v) -> {if(n == k){return 1;}else{return 0;}}) == 1 ;     
     }
     /*  Implementieren Sie eine Methode doubleGreaterN(IntIntPairs pairs, int n), die für jedes gültigen Paar (k,v) in pairs, dessen Wert k in keys größer als der Wert n ist, zu pairs ein weiteres Paar (k,2*v) hinzufügt, sofern in pairs noch Einträge möglich sind. */
     public static void doubleGreaterN( IntIntPairs pairs, int n )
     {
      
      IntIntPairs greater = pairs.extract((k,v) -> k>v);
      greater.manipulate((k,v) -> k, (k,v) -> v*2);
      pairs.combine(greater);
    }
     /* Implementieren Sie eine Methode IntIntPairs concat(IntIntPairs first, IntIntPairs second), die ein neues INtIntPairs-Objekt erzeugt, dass alle gültigen Paare von first und second enthält. first und second sollen nicht geändert werden */
     public static IntIntPairs concat(IntIntPairs first, IntIntPairs second)
     {
         IntIntPairs newPairs = new IntIntPairs(first.accumulate((k,v) -> 1) + second.accumulate((k,v) -> 1) );
         newPairs.combine(first);
         newPairs.combine(second);
         return newPairs;
     }
}