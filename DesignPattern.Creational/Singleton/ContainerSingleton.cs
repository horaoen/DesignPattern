using System.Collections;
using System.Data;

namespace DesignPattern.Creation.Singleton;

public class ContainerSingleton
{
   private static readonly Hashtable Container = new Hashtable();

   public static void PutInstance(string key, object instance)
   {
       if (!String.IsNullOrWhiteSpace(key) && instance != null)
       {
           if (!Container.ContainsKey(key))
           {
                Container.Add(key, instance);
           }
       }
   }

   public static object GetInstance(string key)
   {
       return Container[key];
   }
}