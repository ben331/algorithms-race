package threads;

public class Chronometer extends Thread{
	private int min;
	private int seg;
	private int milli;
	private boolean active;
	
	public Chronometer () {
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public void run() {
		try
        {
            while( active )
            {
                Thread.sleep( 4 );
                
                milli += 4;
                 
                
                if( milli == 1000 )
                {
                    milli = 0;
                    seg += 1;
                    
                    if( seg == 60 )
                    {
                        seg = 0;
                        min++;
                    }
                }          
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	
	@Override
	public String toString() {
		
		String textMin;
		String textSeg;
		String textMilli;
		
		//This is only esthetic so that it is always in format
        //00:00:000
        if( min < 10 ) textMin = "0" + min;
        else textMin = min+"";
        
        if( seg < 10 ) textSeg = "0" + seg;
        else textSeg = seg+"";
         
        if( milli < 10 ) textMilli = "00" + milli;
        else if( milli < 100 ) textMilli = "0" + milli;
        else textMilli = milli+"";
        
		return textMin + ":" + textSeg + ":" + textMilli;
	}
}
