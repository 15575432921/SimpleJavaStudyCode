package bloom;

import java.util.BitSet;
import java.util.Random;

public class MyBloomFilter {
    private static final int DEFAULT_SIZE=1<<24;
    private static final int[] SEEDS=new int[]{3,13,46,71,91,134};
    private BitSet bitSet=new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func=new SimpleHash[SEEDS.length];
    public MyBloomFilter(){
        for (int i = 0; i < SEEDS.length; i++) {
            func[i]=new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }
    public void add(Object value){
        for (int i = 0; i < SEEDS.length; i++) {
            bitSet.set(func[i].hash(value),true);
        }

    }
    public boolean contain(Object value)
    {
        for (int i = 0; i < SEEDS.length; i++) {
            if(!bitSet.get(func[i].hash(value)))
            {
                return false;
            }
        }
        return true;
    }
    public class SimpleHash{
        private int cap;
        private int seed;
        public SimpleHash(int cap,int seed){
            this.cap=cap;
            this.seed=seed;
        }
        public int hash(Object value){
            int h;
            int res=Math.abs(seed*(cap-1)&((h = value.hashCode()) ^ (h >>> 16)));
            System.out.println("res "+res+" "+(res>=cap));
            return (value==null)?0:Math.abs(seed*(cap-1)&((h = value.hashCode()) ^ (h >>> 16)));
        }
    }

    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contain(value1));
        System.out.println(filter.contain(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contain(value1));
        System.out.println(filter.contain(value2));
        Random random = new Random();
        while(true)
        {
            int i = random.nextInt();
            System.out.println("i "+i);
            filter.add(i);
        }

    }
}
