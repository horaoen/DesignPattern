using System;

namespace DesignPattern.Principle.SingleResponsibility
{
    public class Method
    {
        public string UserName { get; set; }
        public string Address { get; set; }

        public Method(string userName, String address)
        {
            UserName = userName;
            Address = address;
        }
        //public void UpdateUserInfo(string userName, string address)
        //{
        //    UserName = userName;
        //    Address = address;
        //}

        public void UpdateUserName(string userName)
        {
            UserName = userName;
        }

        public void UpdateAddress(string address)
        {
            Address = address;
        }
    }
}
