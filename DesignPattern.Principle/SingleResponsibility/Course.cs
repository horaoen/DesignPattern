using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPattern.Principle.SingleResponsibility
{
    public class Course : ICourseContent, ICourseManager
    {
        public string GetCourseName()
        {
            throw new NotImplementedException();
        }

        public byte[] GetCourseVideo()
        {
            throw new NotImplementedException();
        }

        public void StudyCourse()
        {
            throw new NotImplementedException();
        }

        public void RefundCourse()
        {
            throw new NotImplementedException();
        }
    }
}
