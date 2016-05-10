using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MvcLoginRegistration.Models
{
    public class Tickets
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public int Row { get; set; }
        public int Number { get; set; }
    }
    public class TicketsDBContext : DbContext
    {
        public DbSet<Tickets> Tickets { get; set; }
    }
}