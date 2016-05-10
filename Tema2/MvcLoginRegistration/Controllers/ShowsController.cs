using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using MvcLoginRegistration.Models;

namespace MvcLoginRegistration.Controllers
{
    public class ShowsController : Controller
    {
        private ShowDBContext db = new ShowDBContext();

        // GET: /Shows/
        public ActionResult Index()
        {
            return View(db.Shows.ToList());
        }

        // GET: /Shows/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Shows shows = db.Shows.Find(id);
            if (shows == null)
            {
                return HttpNotFound();
            }
            return View(shows);
        }

        // GET: /Shows/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: /Shows/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include="ID,Title,premiereDate,Director,Distributiob,TicketsNumber")] Shows shows)
        {
            if (ModelState.IsValid)
            {
                db.Shows.Add(shows);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(shows);
        }

        // GET: /Shows/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Shows shows = db.Shows.Find(id);
            if (shows == null)
            {
                return HttpNotFound();
            }
            return View(shows);
        }

        // POST: /Shows/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include="ID,Title,premiereDate,Director,Distributiob,TicketsNumber")] Shows shows)
        {
            if (ModelState.IsValid)
            {
                db.Entry(shows).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(shows);
        }

        // GET: /Shows/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Shows shows = db.Shows.Find(id);
            if (shows == null)
            {
                return HttpNotFound();
            }
            return View(shows);
        }

        // POST: /Shows/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Shows shows = db.Shows.Find(id);
            db.Shows.Remove(shows);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
