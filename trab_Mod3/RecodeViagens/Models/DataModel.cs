using Microsoft.EntityFrameworkCore;

namespace Touristando.Models
{
    public class DataModel : DbContext
    {
        public DbSet<Customer> Customer { get; set; }
        public DbSet<Transit> Transit { get; set; }
        public DbSet<Travel> Travel { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionBuilder)
        {
            optionBuilder.UseSqlServer(connectionString: @"Server=(localdb)\mssqllocaldb;Database=TouristandoDB;Integrated Security=True");
        }
    }
}
