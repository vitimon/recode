using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Touristando.Models
{
    public class Travel
    {
        [Key]
        public int id_travel { get; set; }
        public int customerId { get; set; }
        public int transitId { get; set; }
        
        [ForeignKey("customerId")]
        public virtual Customer Customer { get; set; }
        [ForeignKey("transitId")]
        public virtual Transit Transit { get; set; }

        public string promo_code { get; set; }
        public int tickets { get; set; }
        private float totalPrice { get; set; }
        public string status { get; set; }
    }
}
