import java.util.Scanner;

class Tree
{
   public String city;
   public String date;
   public String temperature;
   public String humidity;
   public String wind_speed;
   public String wind_direction;
   public Tree left,right;
   
  Tree(String city,String date,String temperature,String humidity,String wind_speed, String wind_direction)
   { 
     this.city=city;
     this.date=date;
     this.temperature=temperature;
     this.humidity=humidity;
     this.wind_speed=wind_speed;
     this.wind_direction=wind_direction;
     left=null;
     right=null;
   }
}
public class Weather
{
    private Tree root;
    Scanner sc= new Scanner(System.in);
    Tree st;
    
    
   public void create(String city,String date,String temperature,String humidity,String wind_speed,String wind_direction)
    {        
       System.out.println("\n enter name of city=");
       root = new Tree(city,date,temperature,humidity,wind_speed,wind_direction);
       root.city=sc.next();
        System.out.println("\n enter name of date=");
     
       root.date=sc.next();
        System.out.println("\n enter name of temperature=");
      
       root.temperature=sc.next();
        System.out.println("\n enter name of humidity=");
     
       root.humidity=sc.next();
        System.out.println("\n enter name of wind_speed=");
      
       root.wind_speed=sc.next();
       System.out.println("\n enter  wind_direction=");
   
       root.wind_direction=sc.next();
       
       int ch;
       do{
        System.out.println("\n do you want add more data(yes=1/no=0)=");
         ch=sc.nextInt();
         if(ch==1)
         {
             System.out.println("\n enter the city=");
             Tree st = new Tree(city,date,temperature,humidity,wind_speed,wind_direction);
             st.city=sc.next();
             insert(root,st);
             System.out.println("\n enter name of date=");
       st.date=sc.next();
             insert(root,st);
        System.out.println("\n enter name of temperature=");
       st.temperature=sc.next();
             insert(root,st);
        System.out.println("\n enter name of humidity=");
       st.humidity=sc.next();
             insert(root,st);
        System.out.println("\n enter name of wind_speed=");
       st.wind_speed=sc.next();
             insert(root,st);
       System.out.println("\n enter  wind_direction=");
       st.wind_direction=sc.next();
             insert(root,st);
         }
       }while(ch==1);
    }
    
    
    public void insert(Tree root,Tree st)
    {
        char ch1;
        System.out.println("\n the root node is "+root.city);
        if(st.city.compareTo(root.city) < 0) 
        {
            if(root.left==null)
            {
                root.left=st;
            }
            else
            {
                insert(root.left,st);
            }
        }
        else if(st.city.compareTo(root.city) > 0)
        {
            if(root.right==null)
            {
                root.right=st;
            }
            else
            {
                insert(root.right,st);
            }
        }
    }

    
    
    
   public Tree delete(Tree root,String del_d)
    {
        if(root==null)
        {
           System.out.println("Tree is empty");
        }
       if(root.right==null && root.left==null)
       {
            root=null;
       }
       if(root!=null)
       {
        if(del_d.compareTo(root.city) < 0)
        {
          root.left=delete(root.left,del_d);
        }
        else if(del_d.compareTo(root.city) > 0)
        {
          root.right=delete(root.right,del_d);
        }
            
        else
       {
        Tree temp=Findmax(root.left);
        root.city=temp.city;
        delete(root.left,temp.city);
       }
      }
      return root;
    }
    Tree Findmax(Tree root)
    {
       root=root.left;
       while (root.right!=null)
       {
         root=root.right;
       }
      return root;
    }

/*

public Tree update(Tree root,String value)
{
    if(value.compareTo(root.data) < 0)
    {
        if(value.equals(root.data))
        {
            System.out.println("enter the new value");
            root.data=sc.next();
        }
        update(root.left,value);
    }
    else if(value.compareTo(root.data) > 0)
    {
        
        if(value.equals(root.data))
        {
             System.out.println("enter the new value");
             root.data=sc.next();
        }
        update(root.right,value);
    }
    if(value.equals(root.data))
    {
        System.out.println("enter the new value");
        root.data=sc.next();
    }
    return root;
}
    */
    public void inorder(Tree root)
    { 
        if(root!=null)
        {
           inorder(root.left);
           System.out.print(root.city+"\t");
         System.out.print(root.date+"\t");
          System.out.print(root.temperature+"\t");
          System.out.print(root.humidity+"\t");
           System.out.print(root.wind_speed+"\t");
            System.out.print(root.wind_direction+"\t");
           inorder(root.right);
            System.out.print("\n");
        }
    }


    public static void main(String[] args)
   {
        int ch;
        String del_d,value;
        Weather W =new Weather();
        do
    {
        System.out.println(" \n menu \n 1.create \n 2.inorder \n 3.delete \n 4.Update \n 0.exit");
        System.out.println(" enter your choice=");
        ch=W.sc.nextInt();
        switch(ch)
        {
            case 1:
            W.create("","","","","","" );
            break;
            case 2:
            W.inorder(W.root);
            break;
            case 3:
            System.out.println("enter the city which u want to remove from tree=");
            del_d=W.sc.next();
            W.delete(W.root,del_d);
            break;
           /* case 4:
            System.out.println("enter the new data which you want to repleace=");
            value=E.sc.next();
            W.update(W.root,value);
            break;*/
        }
    } while (ch!=0);
    }
}
