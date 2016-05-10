using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace MvcLoginRegistration.Models
{
    public class Shows
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public DateTime premiereDate { get; set; }
        public string Director { get; set; }
        public string Distributiob { get; set; }
        public int TicketsNumber { get; set; }
    }
    public class ShowDBContext : DbContext
    {
        public DbSet<Shows> Shows { get; set; }
    }
}