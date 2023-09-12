import java.util.Scanner;

class Tree
{
   public String data,date,amt;
   public Tree left,right;
   Tree(String data,String date,String amt)
   { 
     this.data=data; // class attribute with the same name of the constructor parameter so it will initilize the variables
     this.date=date;
     this.amt=amt;
     left=null;
     right=null;
   }
}
public class Even
{
    private Tree root;
    Scanner sc= new Scanner(System.in);
    Tree st; //temporory tree object
    
    public void create(String data,String date,String amt)
    {        
       System.out.println("\n enter the category name=");
       root = new Tree(data,date,amt); //memory allocation
       root.data=sc.next();
       System.out.println("\n enter the date=");
       root.date=sc.next();
       System.out.println("\n enter the amount that you have spent=");
       root.amt=sc.next();

       int ch;
       do{
        System.out.println("\n do you want to add more expenses(yes=1/no=0)=");
         ch=sc.nextInt();
         if(ch==1)
         {
             System.out.println("\n enter the new category=");
             Tree st = new Tree(data,date,amt);
             st.data=sc.next();
             insert(root,st);
               System.out.println("\n enter the date=");
             st.date=sc.next();
             insert(root,st);
             System.out.println("\n enter the amount=");
             st.amt=sc.next();
             insert(root,st);//
         }
       }while(ch==1);
    }
    public void insert(Tree root,Tree st)
    {
        char ch1;
        System.out.println("\n the category is "+root.data);
        if(st.data.compareTo(root.data) < 0) // it compares the string data when it is less it return -1 then insert in left
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
        else if(st.data.compareTo(root.data) > 0)
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
        if(del_d.compareTo(root.data) < 0)
        {
          root.left=delete(root.left,del_d);
        }
        else if(del_d.compareTo(root.data) > 0)
        {
          root.right=delete(root.right,del_d);
        }
            
        else
       {
        Tree temp=Findmax(root.left);
        root.data=temp.data;
        delete(root.left,temp.data);
       }
      }
      return root;
    }
    Tree Findmax(Tree root) // 
    {
       root=root.left;
       while (root.right!=null)
       {
         root=root.right;
       }
      return root;
    }

public Tree update(Tree root,String value)
{
    if(value.compareTo(root.data) < 0)
    {
        if(value.equals(root.data))
        {
            System.out.println("enter the new category");
            root.data=sc.next();
        }
        update(root.left,value);
    }
    else if(value.compareTo(root.data) > 0)
    {
        
        if(value.equals(root.data))
        {
             System.out.println("enter the new category");
             root.data=sc.next();
        }
        update(root.right,value);
    }
    if(value.equals(root.data))
    {
        System.out.println("enter the new category");
        root.data=sc.next();
    }
    return root;
}
public void inorder(Tree root) {
    if (root != null) {
        inorder(root.left);
        System.out.printf("%-20s%-20s%-20s\n", root.data, root.date, root.amt);
        inorder(root.right);
    }
}
/*
    public void inorder(Tree root)
    { 
        if(root!=null)
        {
           inorder(root.left);
           System.out.print(root.data+"\t");
           System.out.print(root.date+"\t");
           System.out.print(root.amt+"\t");
           inorder(root.right);
           System.out.print("\n");
           
        }
    }*/


    public static void main(String[] args)
    {
        int ch;
        String del_d,value;
        Even E=new Even();
        do
    {
        System.out.println(" \n menu \n 1.Adding the Expense \n 2.Display the Expenses(by inorder) \n 3.Deleting the category of the expense \n 4.Update the category of Expense \n 0.exit");
        System.out.println(" enter your choice=");
        ch=E.sc.nextInt();
        switch(ch)
        {
            case 1:
            E.create("","","");
            break;
            case 2:
            System.out.printf("%-20s%-20s%-20s\n", "Category", "Date", "Amount");//In this modified inorder method, the printf method is used to print the data in a table format. The %-20s specifier is used to print the data in a left-justified column with a width of 20 characters. 
            E.inorder(E.root);
            break;
            case 3:
            System.out.println("enter the task which is complete then remove it from tree=");
            del_d=E.sc.next();
            E.delete(E.root,del_d);
            break;
            case 4:
            System.out.println("enter the existing category which you want to replace with new category=");
            value=E.sc.next();
            E.update(E.root,value);
            break;
        }
    } while (ch!=0);
   }
}
