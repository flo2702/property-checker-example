package client;

import qual.Interval;

public class IntTest {
    // :: error: assignment.type.incompatible
    @Interval(min="1", max="2") int field = 3;
    
    
    @SuppressWarnings("unused")
	public static void foo0(@Interval(min="2", max="2") int arg0, @Interval(min="2", max="5") int arg1) {
        @Interval(min="1", max="3") int l0 = arg0;
        @Interval(min="1", max="5") int l1 = arg1;
        
        // :: error: assignment.type.incompatible
        @Interval(min="1", max="2") int l2 = arg1;
        
        // This does not work yet. It would require a contract for the + operator.
        //@Interval(min="4", max="7") int l3 = arg0 + arg1;
        
        // :: error: assignment.type.incompatible
        @Interval(min="2", max="5") int l4 = arg0 + arg1;
        // :: error: assignment.type.incompatible
        @Interval(min="2", max="2") int l5 = arg0 + arg1;
        
        @Interval(min="4", max="7") int lit1 = 5;
        
        // :: error: unary.increment.type.incompatible
        ++lit1;
    }
}
