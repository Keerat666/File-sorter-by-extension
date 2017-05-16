import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class fileTest 
{
	static String src="C:/Users/gurke/desktop"; // save the path of the folder you want to process here 
	static void display(String a[] , int w)
	{
		for(int x=0;x<w;x++)
		{
			
				System.out.println(a[x]);
				System.out.println();
		}
			
	}
	static void copy(String s , String d)
	{
		
		File source = new File(s);
		File dest = new File(d);
		   source.setReadable(true);
		   dest.setReadable(true);
			InputStream is = null;
	        OutputStream os = null;
	        try {
	          is = new FileInputStream(source);
	            os = new FileOutputStream(dest);
	            byte[] buffer = new byte[1024];
	            int length;
            while ((length = is.read(buffer)) > 0) {
	                os.write(buffer, 0, length);
	            }
	        }catch(Exception ex) {
	            System.out.println("Unable to copy file:"+ex.getMessage());
	        }   
	        finally {
	            try {
	                is.close();
	                os.close();
	            }catch(Exception ex) {}
				
	        }
	}
	public static void main(String args[])
	{
		File folder = new File(src);
		File[] listOfFiles = folder.listFiles();
		String s[]=new String[100];
		int c=0;

    for (int i = 0; i < listOfFiles.length; i++) 
	{
      if (listOfFiles[i].isFile()) 
	  {
		  s[c]=listOfFiles[i].getName();
		  c++;
        //System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) 
	  {
        //System.out.println("Directory " + listOfFiles[i].getName());
      }
	  
    }
	
	String p[]=new String[100];
	int a=0;
	String i[]=new String[100];
	int b=0;
	String m[]=new String[100];
	int n=0;
	String z[]=new String[100];
	int f=0;
	String other[]=new String [100];
		int k=0;
	for(int r=0;r<c;r++)
	{
		boolean flag=true;
		String t=s[r];
		int q=t.lastIndexOf(".");
		String ext=t.substring(q+1);
		//System.out.println(ext);
			if(ext.equals("pdf") || ext.equals("docx") || ext.equals("doc"))
			{
				p[a]=s[r];
				a++;
				flag=false;
			}
				if(ext.equals("jpg") || ext.equals("jpeg")|| ext.equals("png") )
			{
				i[b]=s[r];
				b++;
				flag=false;
			}
				if(ext.equals("mp3") || ext.equals("mp4")|| ext.equals("avi") || ext.equals("mkv") || ext.equals("m4a") )
			{
				m[n]=s[r];
				n++;
				flag=false;
			}
				if(ext.equals("zip") || ext.equals("rar") )
			{
				z[f]=s[r];
				f++;
				flag=false;
			}
			if(flag)
			{
				other[k]=s[r];
				k++;
				flag=true;
				
			}
			
			
		
	
	
	
	
		
	}
	File dir = new File("D:/Sorted");
		dir.mkdir();
	Scanner ab=new Scanner(System.in);
	System.out.println("Enter 1 to see the list of documents \nEnter 2 to see the list of images \nEnter 3 to see the list of media\nEnter 4 to find zip files\nEnter 5 for all other types ");
	int ch=ab.nextInt();
	if(ch==1)
	{
		System.out.println("Documents");
		System.out.println("_________________________________________________________________________________________________________");
		System.out.println();
		display(p,a);
				System.out.println("_________________________________________________________________________________________________________");

		File dir1 = new File("D:/Sorted/pdf");
		dir1.mkdir();
		try{
		for(int d=0;d<a;d++)
		{
			String dir2=(src+"/"+p[d]);
			String dir3=("D:/Sorted/pdf/"+p[d]);
			copy(dir2,dir3);
		}
		}finally{System.out.println("Copying has been done successfully !");}
	}
	if(ch==2)
	{
		System.out.println("Images");
		System.out.println("_________________________________________________________________________________________________________");
		System.out.println();
		display(i,b);
				System.out.println("_________________________________________________________________________________________________________");

		File dir1 = new File("D:/Sorted/Images");
		dir1.mkdir();
		try{
		for(int d=0;d<b;d++)
		{
			String dir2=(src+"/"+i[d]);
			String dir3=("D:/Sorted/Images/"+i[d]);
			copy(dir2,dir3);
		}
		}finally{System.out.println("Copying has been done successfully !");}
		
	}
	if(ch==3)
	{
		System.out.println("Videos and audios");
		System.out.println("_________________________________________________________________________________________________________");
		System.out.println();
		display(m,n);
				System.out.println("_________________________________________________________________________________________________________");

		File dir1 = new File("D:/Sorted/Media");
		dir1.mkdir();
		try{
			for(int d=0;d<n;d++)
		{
			String dir2=("C:/Keerat Studies/"+m[d]);
			String dir3=("D:/Sorted/Media/"+m[d]);
			copy(dir2,dir3);
			
		}
	}finally{System.out.println("Copying has been done successfully !");}
	}
	
	if(ch==4)
	{
		System.out.println("Zip files");
		System.out.println("_________________________________________________________________________________________________________");
		System.out.println();
		display(z,f);
		System.out.println("_________________________________________________________________________________________________________");

		File dir1 = new File("D:/Sorted/Zip");
		dir1.mkdir();
		try{
		for(int d=0;d<f;d++)
		{
			String dir2=(src+"/"+z[d]);
			String dir3=("D:/Sorted/Zip/"+z[d]);
			copy(dir2,dir3);
		}
		}finally{System.out.println("Copying has been done successfully !");}
	}
	if(ch==5)
	{
		System.out.println("Misc");
		System.out.println("_________________________________________________________________________________________________________");
		System.out.println();
		display(other,k);
		System.out.println("_________________________________________________________________________________________________________");

		File dir1 = new File("D:/Sorted/Misc");
		dir1.mkdir();
		try{
		for(int d=0;d<k;d++)
		{
			String dir2=(src+"/"+other[d]);
			String dir3=("D:/Sorted/Misc/"+other[d]);
			copy(dir2,dir3);
		}
		}finally{System.out.println("Copying has been done successfully !");}
	}
	

	
	
}
}
