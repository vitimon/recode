using System.ComponentModel.DataAnnotations;

namespace Touristando.Models
{
    public class Transit
    {
        [Key]
        public int id_transit { get; set; } 
        public string origin { get; set; }
        public string destination  { get; set; }
        public float price  { get; set; }
    }
}
