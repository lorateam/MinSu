package util;

/**
 * 关于翻页操作的工具类
 */
public class Page
{
    int start;
    int count;
    int total;
    String param;

    public Page(int start,int count)
    {
        super();
        this.start=start;
        this.count=count;
    }

    public int getStart()
    {
        return start;
    }
    public void setStart(int start)
    {
        this.start=start;
    }
    public int getCount()
    {
        return count;
    }
    public void setCount(int count)
    {
        this.count=count;
    }
    public int getTotal()
    {
        return total;
    }
    public void setTotal(int total)
    {
        this.total=total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isHasPrevious()
    {

        if(start==0)
            return false;
        return true;
    }
    //获得最后页
    public int getLast()
    {
        int last;
        if(0==total%count)
            last=total-count;
        else
            last=total-count;
        last=last<0?0:last;
        return last;
    }
    //是否有一页
    public boolean isHasNext()
    {
        if(start==getLast())
        {
            return false;
        }
        return true;
    }
    //得到总页数
    public int getTotalPage()
    {
        int totalPage;
        if(0==total%count)
            totalPage=total/count;
        else
            totalPage=total/count+1;
        if(0==totalPage)
            totalPage=1;
        return totalPage;
    }



}

