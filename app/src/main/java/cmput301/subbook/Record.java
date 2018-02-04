package cmput301.subbook;

import java.util.Currency;
import java.util.Date;

/**
 * Created by thesh on 1/29/2018.
 */

public class Record {
    private String name;
    private Date date;
    private Currency monthly_charge;
    private String comment;

    Record(String name, Currency monthly_charge)
    {
        this.name = name;
        this.monthly_charge = monthly_charge;
    }

    public String getName()
    {
        return name;
    }

    public Date getDate()
    {
        return date;
    }

    public Currency getMonthlyCharge()
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






}
