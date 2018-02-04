package cmput301.subbook;

import java.util.Date;

/**
 * Created by thesh on 1/29/2018.
 */

public class Record {
    private String name;
    private String date;
    private Double monthly_charge;
    private String comment;

    Record(String name, Double monthly_charge, String comment, String date)
    {
        this.name = name;
        this.monthly_charge = monthly_charge;
        this.comment = comment;
        this.date = date;
    }

    public String getName()
    {
        return name;
    }

    public String getDate()
    {
        return date;
    }

    public Double getMonthlyCharge()
    {
        return monthly_charge;
    }

    public String getComment()
    {
        return comment;
    }

    public void setName(String name)
    {
        if (name.length() < 20)
        {
            this.name = name;
        }

        else
        {
            //do nothing and throw an exception
           // throw new NameTooLongException;
        }

    }

    public void setComment(String comment)
    {
        if (comment.length() < 30)
        {
            this.comment = comment;
        }

        else
        {
            //throw new Exception
        }
    }

    public void setMonthly_charge(Double amnt)
    {
        this.monthly_charge = amnt;
    }

}
