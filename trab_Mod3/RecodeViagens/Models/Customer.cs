using System.ComponentModel.DataAnnotations;

namespace RecodeViagens.Models
{
    public class Customer
    {
        [Key]
        public int id_customer { get; set; } 
        public string name { get; set; }    
        public string email { get; set; }
    }
}
