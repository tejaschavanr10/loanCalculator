package com.as.samples;

// From "Professional Java Server Programming", Patzer et al.,

public class html
{
   public static final int NORMAL   = 0;
   public static final int HEADING  = 1;
   public static final int LINE     = 2;

   public StringBuffer buffer;

   public html (String title)
   {
      buffer = new StringBuffer(4096);
      this.buffer.append("<html>\n<head>\n<title>");
      this.buffer.append(title);
      this.buffer.append("</title>\n</head>\n<body>");
   }

   public void add (int style, String text, boolean linebreak)
   {
      switch (style)
      {
         case NORMAL:
            this.buffer.append(text);
            break;
         case HEADING:
            this.buffer.append("\n<h1>");
            this.buffer.append(text);
            this.buffer.append("</h1>\n");
            break;
         case LINE:
            this.buffer.append("<hr>\n");
            break;
         default:
            break;
      }
      if (linebreak)
      {
         buffer.append("<br>\n");
      }
   }

   public String getPage ()
   {
      this.buffer.append("</body>\n</html>");
      return this.buffer.toString();
   }
}